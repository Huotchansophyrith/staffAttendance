$(document).ready(function () {
    let data = {};
    let uploadFileFormData = {};
    const userReqLeaveApiUrl = "/api/v1/userReqLeave";
    const userApiUrl = "/api/v1/users";

    const d = new Date();


    const startDate = $("#datepicker");
    const endDate = $("#datepicker1");
    const typeLeave = $("#typeLeave");
    const status = $("#status");
    const reason = $("#reason");

    $('#datepicker,#datepicker1').datepicker({
        autoclose: true,
        todayHighlight: true,
        dateFormat: 'dd-M-yy'
    });

    $('#datepicker-icon').click(function() {
        $('#datepicker').datepicker('show');
    });

    $('#datepicker-icon1').click(function() {
        $('#datepicker1').datepicker('show');
    });

    function validateAndAssignData() {

        let isValidate = validateInputField(
            [
                startDate,
                endDate,
                typeLeave,
                status,
                reason,
            ]
        );

        if (!isValidate) return false;

        data = {
            "typeLeave": typeLeave.val(),
            "status": status.val(),
            "startDate": startDate.val(),
            "endDate": endDate.val(),
            "reason": reason.val(),
            // "username": username,
            "userId": userId


        };

        return true;
    }

    $('#create').on('click',function() {
        if(validateAndAssignData()){
            console.log(data);
            saveReqLeave();
        }
    });

    $('#update').on('click',function() {
        validateAndAssignData();
        data['userSeq'] = userId.userSeq;
        updateUser();
    });

    function saveReqLeave() {
        postRequest(userReqLeaveApiUrl, data, dataRes => {

            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Request Leave Created").then(() => $(location).attr('href', "/userReqLeave/reqLeaveList"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }



    function updateUser() {
        putRequest(userApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("User Updated").then(() => $(location).attr('href', "/users"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }


});
