$(document).ready(function () {

    const baseUrl = "/api/v1/users-g";
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
            {"data": "gSeq"},
            {"data":"managerId"},
            {"data":"memberId"},
            {"data":"userId"}
        ],
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
            $('td:eq(0)', nRow).html(iDisplayIndexFull +1);
        },
        "createdRow": function (row, data) {
            // console.log(data);
            const $cell = $(row).find("td");
            const id = data.gSeq;
            const link = "<div class='ellipsis'><a class='link' href='/users-g/update/" + id + "' data-btn='link' title='" + id + "'>" + id + "</a></div>";

            $cell.eq(0).html(autoIncrNum--);
//            $cell.eq(2).html(link);
        }
    });

    // reload datatable
    function reLoadTable() {
        CTable.ajax.reload();
    }
});