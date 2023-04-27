$(document).ready(function () {

    const baseUrl = "/api/v1/staffs";
    let autoIncrNum;
    const CTable = $('#data-table').DataTable({
        order: [[ 0, "desc" ]],
        responsive: true,
        screenX: true,
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
            {"data": "staff_seq"},
            {"data":"full_name"},
            {"data":"staff_number"},
            {"data":"gender"},
            {"data":"phone"},
            {"data":"email"},
            {"data":"pos_id"},
            {"data":"department_id"},
            {"data":"branch_id"},
            // {"data":"username"},
            {"data": null, "width": "5%"}
        ],
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
                $('td:eq(0)', nRow).html(iDisplayIndexFull +1);
            },
        "createdRow": function (row, data) {
            // console.log(data);
            const $cell = $(row).find("td");
            const id = data.staff_seq;
            const name = data.full_name;
            let gender;
            if (data.gender == 1){
                gender = "<button type='button' class='btn btn-success btn-sm' title='female'>Female</button>"
            }else {
                gender = "<button type='button' class='btn btn-primary btn-sm' title='male'>Male</button>"
            }
            const link = "<div class='ellipsis'><a class='link' href='/staffs/update/" + id + "' data-btn='link' title='" + id + "'>" + name + "</a></div>";
            let btnDelete;
                btnDelete = "<button type='button' class='btn btn-danger btn-sm' data-btn='delete' data-seq='" + id + "' title='Delete'>Delete</button>";

            $cell.eq(0).html(autoIncrNum--);
            $cell.eq(1).html(link);
            $cell.eq(3).html(gender);
            $cell.eq(9).html(btnDelete);
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
            'Do you want to delete this company?',
            'warning',
            true,
            "Delete",
            "#dc3545")
            .then(result => {
                if (result.value) {
                    deleteRequest(baseUrl + "/delete/" + deleteId, response => {
                        if (response.status === 200) {
                            toastAlertSuccessBigNoBtn("company deleted!").then(()=>reLoadTable())
                        } else {
                            toastAlertError(response.responseJSON.message)
                        }
                        $(this).prop("disabled", false);
                    });
                }
            })
    });

});