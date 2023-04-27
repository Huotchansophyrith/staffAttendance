$(document).ready(function () {
    let data = {};
    const comApiUrl = "/api/v1/company";
    const getBranchUrl = "/api/v1/branches";

    /*get input element*/
    const companyName = $("#companyName");
    const shortName = $("#shortName");
    const description = $("#description");
    const branch = $("#branch");

    selectBranch("#branch","-- Choose Branch --",getBranchUrl);

    if(action === "update"){
        let brOpt = new Option(brName.branchname,brName.branchid, true, true);
        branch.append(brOpt).trigger('change');
        branch.prop('disabled', 'disabled');
    }

    function validateAndAssignData() {

        const branchId = $('#branch').select2('val');

        if (!branchId){
            toastAlertInfo("Please select the branch...!");
        }

        let isValidate = validateInputField(
            [
                companyName,
                shortName
            ]
        );

        if (!isValidate) return false;

        data = {
            "company_name": companyName.val(),
            "company_short_name": shortName.val(),
            "description": description.val(),
            "branch_id": +branchId,
            "adm_id": +currentUser

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
            data['company_seq'] = comId.company_seq;
            // console.log("da",data);
            update();
        }
    });

    function save() {

        postRequest(comApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Company Created").then(() => $(location).attr('href', "/company"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function update() {
         // console.log(data);
        putRequest(comApiUrl, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Company Updated").then(() => $(location).attr('href', "/company"))
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
                dataBr.push({id: d.branch_seq, text: d.name})
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
