$(document).ready(function () {

    const baseUrl = "/api/v1/adminReqLeave"
    const baseUrl1 = "/api/v1/adminReqLeave/refuse";

    const UserReqLeaveUrl = "/api/v1/userReqLeave";

    let autoIncrNum;
    const CTable = $('#data-table').DataTable({
        order: [[0, "desc"]],
        responsive: true,
        "ajax": {
            "url": baseUrl,
            "type": "GET",
            "dataSrc": function (d) {
                autoIncrNum = d.data.length;
                console.log(d.data);
                return d.data;
            }
        },

        "columnDefs": [
            {"className": "dt-center", "targets": "_all"}
        ],
        "columns": [
            {"data": "reqLeaveSeq"},
            {"data": "userIdNm"},
            {"data": "typeLeave"},
            {"data": "startDate"},
            {"data": "endDate"},
            {"data": "reason"},
            {"data": "status"},

            {"data": null, "width": "5%"}
        ],
        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
        },
        "createdRow": function (row, data) {
            // console.log(data);
            const $cell = $(row).find("td");
            const id = data.reqLeaveSeq;
            const name = data.typeLeave;
            const userNum = data.userNum;
            const status = data.status;

            let btnApproveRefuse;
            let btnCancel;


            let link;
            let waiting ;
            if(status=='Pending'){
                    waiting ="<div class='ellipsis'>" + status + "</div>";
            }else if(status=='Approved'){
                waiting="<div class='ellipsis1'>" + status + "</div>";
            }else {
                waiting="<div class='ellipsis2'>" + status + "</div>";
            }

                btnApproveRefuse = "<button type='button' class='btn btn-danger' id='refuse' data-btn='refuse' data-seq='" + id + "' title='refuse'>Refuse</button>" + "&nbsp&nbsp&nbsp"+
                             "<button type='button' class='btn btn-success' id='approve' data-btn='approve' data-seq='" + id + "' title='Approve'>Approve</button> ";


            $cell.eq(0).html(autoIncrNum--);
            $cell.eq(1).html(link);
            $cell.eq(6).html(waiting);
            $cell.eq(7).html(btnApproveRefuse);
        }
    });


    // reload datatable
    function reLoadTable() {
        CTable.ajax.reload();
    }

    let approveId = "";
    $(document).on("click", "[data-btn='approve']", function () {
        approveId = $(this).attr("data-seq");
        approve(approveId);

    });

    function approve(approveId){
        // TODO :  which data is updated
        let data = {
            // "status":"Approved",
            "reqLeaveSeq":approveId
        }

        $.ajax({
            type: "PUT",
            url: baseUrl,
            data: JSON.stringify(data && "" === data ? {} : data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            complete: function (dataRes) {
                console.log(dataRes.responseJSON.statusCode);
                if(dataRes.responseJSON.statusCode === 200){
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Request has been approved',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => $(location).attr('href', "/adminReqLeave/list"))
                } else {
                    toastAlertInfo(dataRes.responseJSON.message);
                }
            }
        });

    }

    let refuseId = "";
    $(document).on("click", "[data-btn='refuse']", function () {
        refuseId = $(this).attr("data-seq");
        // console.log(refuseId)
        refuse(refuseId);

    });

    function refuse(refuseId){

        let data = {
            // "status":"Approved",
            "reqLeaveSeq":refuseId
        }

        $.ajax({
            type: "PUT",
            url: baseUrl1,
            data: JSON.stringify(data && "" === data ? {} : data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            complete: function (dataRes) {
                console.log(dataRes.responseJSON.statusCode);
                if(dataRes.responseJSON.statusCode === 200){
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Request has been refused',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => $(location).attr('href', "/adminReqLeave/list"))
                } else {
                    toastAlertInfo(dataRes.responseJSON.message);
                }
            }
        });


    }








});