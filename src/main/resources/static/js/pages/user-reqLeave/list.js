$(document).ready(function () {

    const baseUrl = "/api/v1/userReqLeave";
    let autoIncrNum;
    const CTable = $('#data-table').DataTable({
        order: [[0, "desc"]],
        responsive: true,
        "ajax": {
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
            {"data": "reqLeaveSeq"},
            {"data": "typeLeave"},
            {"data": "startDate"},
            {"data": "endDate"},
            {"data": "reason"},
            {"data": "status"}

        ],
        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
        },
        "createdRow": function (row, data) {
            const $cell = $(row).find("td");
            const id = data.reqLeaveSeq;
            const name = data.typeLeave;
            const userNum = data.userNum;
            const status = data.status;

            let btnDelete;
            let link;


            let waiting ;
            if(status=='Pending'){
                waiting ="<div class='ellipsis'>" + status + "</div>";
            }else if(status=='Approved'){
                waiting="<div class='ellipsis1'>" + status + "</div>";
            }else {
                waiting="<div class='ellipsis2'>" + status + "</div>";
            }




            btnDelete = "<button type='button' class='btn btn-danger btn-sm' data-btn='delete' data-seq='" + id + "' title='Delete'>Delete</button>";


            $cell.eq(0).html(autoIncrNum--);
            $cell.eq(1).html(link);
            $cell.eq(5).html(waiting);
        }
    });

    // reload datatable
    function reLoadTable() {
        CTable.ajax.reload();
    }



});