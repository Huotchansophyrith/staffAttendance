$(document).ready(function () {
    const getStaffUrl = "/api/v1/users";
    const baseURL = "/api/v1/attn";
    let data = {};

    const time =$.datepicker.formatDate("mm-dd-yy", new Date());
    const AMorPM = new Date().getHours() +':'+ new Date().getMinutes() + ((new Date().getHours() >= 12) ? "PM" : "AM");
    const curTime = $('#currentDate').val(time  +' ' + AMorPM);

    const staff = $("#staff");
    const userId = $("#userId");
    const staffNum = $("#staffNum");
    const attnType = $("#attnType");
    // const currentDate = $("#currentDate");

    selectStaff("#staff","-- Choose staff --",getStaffUrl);

    function validateAndAssignData() {

        const staffId = $('#staff').select2('val');

        if (!staffId){
            toastAlertInfo("Please select the staff...!");
        }
        let isValidate = validateInputField(
            [
                staff
            ]
        );

        if (!isValidate) return false;

        data = {
            "userNum": staffNum.val(),
            "attnType": attnType.val(),
            "attnDt": curTime.val(),
            "createBy" : currentUserName,
            "createBt" : curTime.val(),
            "approveBy": '',
            "approveDt": '',
            "userId": +userId.val()
        };
        return true;
    }

    $('#create').click(function() {
        if(validateAndAssignData()){
            console.log("da",data);
            save();
        }
    });

    $('#update').click(function () {
        if(validateAndAssignData()){
            data['attnSeq'] = attnId.attnSeq;
            // console.log("da",data);
            update();
        }
    });

    function save() {
        postRequest(baseURL, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Attendance Created").then(() => $(location).attr('href', "/attn"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function update() {
        // console.log(data);
        putRequest(baseURL, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Attendance Updated").then(() => $(location).attr('href', "/attn"))
            } else {
                toastAlertInfo(jsonData.message);
            }
        })
    }

    function selectStaff(element, placeHolder, getDataUrl) {
        let dataSt = [];
        let st = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            st = res.responseJSON.data;
            // Get Data for Select2
            st.forEach(d => {
                dataSt.push({id: d.userSeq, text: d.fullName, textN: d.userNum, textU: d.userSeq})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataSt
            }).on('select2:select', e => {
                // console.log(e.params.data.textU);
                $('#staffNum').val(e.params.data.textN);
                $('#userId').val(e.params.data.textU);
            });
        })
    }



});
