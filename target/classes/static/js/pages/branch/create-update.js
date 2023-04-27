$(document).ready(function () {
    let data = {};
    const branchApiUrl = "/api/v1/branches";

    /*get input element*/
    const name = $("#name");
    const address = $("#address");
    const desc = $("#description");

    function validateAndAssignData() {
        let isValidate = validateInputField(
            [
                name
            ]
        );

        if (!isValidate) return false;

        data = {
            "name": name.val(),
            "address": address.val(),
            "description": desc.val()
        };
        return true;
    }

    $('#create').click(function() {
        if(validateAndAssignData()){
            // console.log("da",data);
            saveBranch();

        }
    });

    $('#update').click(function () {
        if(validateAndAssignData()){
            data['brSeq'] = branchId.brSeq;
            updateBranch();
        }
    });

    function saveBranch() {

        postRequest(branchApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Branch Created").then(() => $(location).attr('href', "/branches/list"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function updateBranch() {
         // console.log(data);
        putRequest(branchApiUrl, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Branch Updated").then(() => $(location).attr('href', "/branches/list"))
            } else {
                toastAlertInfo(jsonData.message);
            }
        })
    }
});
