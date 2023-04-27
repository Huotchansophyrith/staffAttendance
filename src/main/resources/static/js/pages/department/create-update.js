$(document).ready(function () {
    let data = {};
    const departApiUrl = "/api/v1/departments";
    const getBranchUrl = "/api/v1/branches";

    /*get input element*/
    const shortName = $("#shortName");
    const desc = $("#description");
    const branch = $("#branch");

    selectBranch("#branch","-- Choose Branch --",getBranchUrl);

    if(action === "update"){
        let brOpt = new Option(BranchName.branchname,BranchName.branchid, true, true);
        branch.append(brOpt).trigger('change');
    }

    function validateAndAssignData() {
        const branchId = $('#branch').select2('val');

        if (!branchId){
            toastAlertInfo("Please select the branch...!");
        }
        let isValidate = validateInputField(
            [
                shortName
            ]
        );

        if (!isValidate) return false;

        data = {
            "name": shortName.val() + desc.val(),
            "short_name": shortName.val(),
            "brId": +branchId,
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
            data['departSeq'] = departId.departSeq;
            update();
        }
    });

    function save() {

        postRequest(departApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Department Created").then(() => $(location).attr('href', "/departments"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function update() {
         // console.log(data);
        putRequest(departApiUrl, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Department Updated").then(() => $(location).attr('href', "/departments"))
            } else {
                toastAlertInfo(jsonData.message);
            }
        })
    }

    function selectBranch(element, placeHolder, getDataUrl) {
        let dataBr = [];
        let br = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            br = res.responseJSON.data;
            // Get Data for Select2
            br.forEach(d => {
                dataBr.push({id: d.brSeq, text: d.name})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataBr
            });
        })
    }
});
