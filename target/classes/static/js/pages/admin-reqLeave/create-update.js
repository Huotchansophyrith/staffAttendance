$(document).ready(function () {
    let data = {};
    const adminReqLeaveApiUrl = "/api/v1/adminReqLeave";
    const userApiUrl = "/api/v1/users";

    const d = new Date();

    const startDate = $("#datepicker");
    const endDate = $("#datepicker1");
    const typeLeave = $("#typeLeave");
    const status = $("#status");
    const reason = $("#reason");


    selectUser("#user","-- Choose User --",userApiUrl);


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

        let userId =$('#user').select2('val');

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
            "userId": userId
        };

        return true;
    }

    $('#create').on('click',function() {
        if(validateAndAssignData()){
            saveReqLeave();
        }
    });

    function saveReqLeave() {
        postRequest(adminReqLeaveApiUrl, data, dataRes => {

            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("DONE")
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }




    function selectUser(element, placeHolder, getDataUrl){
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // console.log(com);     // TODO : which data we receive
            // Get Data for Select2
            com.forEach(d => {
                let userIdNm = d.userNum + "( " + d.username + " )";
                dataCom.push({id: d.userSeq, text: userIdNm})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataCom
            });
        })
    }





});
