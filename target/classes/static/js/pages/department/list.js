$(document).ready(function () {

    const baseUrl = "/api/v1/departments";
    let autoIncrNum;
    const CTable = $('#data-table').DataTable({
        order: [[ 0, "desc" ]],
        responsive: true,
        "ajax" : {
            "url": baseUrl,
            "type": "GET",
            "dataSrc": function (d) {
                autoIncrNum = d.data.length;
                return d.data;
            }
        },


        "columnDefs": [
            {"className": "dt-center", "targets": "_all"}
        ],
        "columns": [
            {"data": "departseq"},
            {"data":"name"},
            {"data":"short_name"},
            {"data":"brid"},
            {"data":"description"},
            {"data": null, "width": "5%"}
        ],
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
                $('td:eq(0)', nRow).html(iDisplayIndexFull +1);
            },
        "createdRow": function (row, data) {
            // console.log(data)
            const $cell = $(row).find("td");
            const id = data.departseq;
            const name = data.name;
            let link;
            let btnDelete;

            if (name ==="default"){
                link = "<div class='ellipsis'>name</div>";
                btnDelete = "<button type='button' class='btn btn-danger btn-sm' data-btn='delete' data-seq='" + id + "' title='Delete' disabled>Delete</button>";
            }else {
                link = "<div class='ellipsis'><a class='link' href='/departments/update/" + id + "' data-btn='link' title='" + id + "'>" + name + "</a></div>";
                btnDelete = "<button type='button' class='btn btn-danger btn-sm' data-btn='delete' data-seq='" + id + "' title='Delete'>Delete</button>";
            }

            $cell.eq(0).html(autoIncrNum--);
            $cell.eq(1).html(link);
            $cell.eq(5).html(btnDelete);
        }
    });

    // reload datatable
    function reLoadTable() {
        CTable.ajax.reload();
    }

    let deleteId = "";
    $(document).on("click", "[data-btn='delete']", function () {
        deleteId = $(this).attr("data-seq");
        toastAlertConfirm(
            'Delete',
            'Do you want to delete this Department?',
            'warning',
            true,
            "Delete",
            "#dc3545")
            .then(result => {
                if (result.value) {
                    deleteRequest(baseUrl + "/delete/" + deleteId, response => {
                        if (response.status === 200) {
                            toastAlertSuccessBigNoBtn("Department deleted!").then(()=>reLoadTable())
                        } else {
                            toastAlertError(response.responseJSON.message)
                        }
                        $(this).prop("disabled", false);
                    });
                }
            })
    });

});