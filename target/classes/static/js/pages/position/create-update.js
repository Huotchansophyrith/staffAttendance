$(document).ready(function () {
    let data = {};
    const posApiUrl = "/api/v1/positions";

    /*get input element*/
    const name = $("#posName");
    const desc = $("#description");

    function validateAndAssignData() {
        let isValidate = validateInputField(
            [
                name
            ]
        );

        if (!isValidate) return false;

        data = {
            "posName": name.val(),
            "description": desc.val()
        };
        return true;
    }

    $('#create').click(function() {
        if(validateAndAssignData()){
            // console.log("da",data);
            save();

        }
    });

    $('#update').click(function () {
        if(validateAndAssignData()){
            data['posSeq'] = posId.posSeq;
            update();
        }
    });

    function save() {
        postRequest(posApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Position Created").then(() => $(location).attr('href', "/positions"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function update() {
         // console.log(data);
        putRequest(posApiUrl, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Position Updated").then(() => $(location).attr('href', "/positions"))
            } else {
                toastAlertInfo(jsonData.message);
            }
        })
    }
});
