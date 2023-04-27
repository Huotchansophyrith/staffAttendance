$(document).ready(function () {
    let data = {};
    let uploadFileFormData = {};
    const staffApiUrl = "/api/v1/staffs";
    const brApiUrl = "/api/v1/branches";
    const posApiUrl = "/api/v1/positions";
    const departApiUrl = "/api/v1/departments";
    const uploadFileUrl = "/api/v1/softfiles/upload";

    // const userApiUrl = "/api/v1/users";

    /*get input element*/
    const fullName = $("#fullName");
    const staffNum = $("#staffNum");
    const age = $("#age");
    const gender = $("#gender");
    const profile_img = $("#profile_img");
    const position = $("#position");
    const email = $("#email");
    const phone = $("#phone");
    const department = $("#department");
    const branch = $("#branch");
    const user = $("#user");

    selectPos("#position","-- Choose position --",posApiUrl);
    selectDeprt("#department","-- Choose department --",departApiUrl);
    selectBr("#branch","-- Choose branch --",brApiUrl);
    // selectUser("#user","-- Choose user --",userApiUrl);


    //Initialize Select file upload
    selectFile("#proImg", "#imgFile");

    if(action === "update"){

        let posOpt = new Option(allName.posname,allName.posid, true, true);
        position.append(posOpt).trigger('change');

        let departOpt = new Option(allName.departname,allName.departid, true, true);
        department.append(departOpt).trigger('change');

        let branchOpt = new Option(allName.branchname,allName.branchid, true, true);
        branch.append(branchOpt).trigger('change');

    }

    function validateAndAssignData() {

        const branchId = $('#branch').select2('val');
        const posId = $('#position').select2('val');
        const departId = $('#department').select2('val');

        if (!branchId){
            toastAlertInfo("Please select the branch...!");
        }
        if (!posId){
            toastAlertInfo("Please select the position...!");
        }

        if (!departId){
            toastAlertInfo("Please select the department...!");
        }

        let isValidate = validateInputField(
            [
                fullName,
                staffNum
            ]
        );

        if (!isValidate) return false;

        data = {
            "staff_number": staffNum.val(),
            "full_name": fullName.val(),
            "age": age.val(),
            "gender": gender.val(),
            "email": email.val(),
            "phone": phone.val(),
            // "profile_img": "imp/akd",
            "account_status": 1,
            "branch_id": +branchId,
            "pos_id": +posId,
            "department_id": +departId,
            "adm_id": +currentUser

        };

        /*Check if Upload Image*/
        let dirWithFileName = [];
        dirWithFileName.push("Staff");
        dirWithFileName.push(fullName.val());

        uploadFileFormData = new FormData();
        uploadFileFormData.append('dir', dirWithFileName);

        logoImg = $('#proImg')[0].files[0];
        if(logoImg !== undefined){
            if(validExts.indexOf(logoImg.name.split('.').pop().toLowerCase()) >= 0){
                uploadFileFormData.append('files', logoImg);
                uploadFile(uploadFileFormData, function (dataRes) {
                    data["profile_img"] = dataRes[0].fileName;
                    data["profile_img_path"] = dataRes[0].filePath;
                })
            } else {
                alert("File must be type " + validExts.toString() + " extension");
                return;
            }
        }
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
            data['staff_seq'] = staffId.staff_seq;
//             console.log("da",data);
            update();
        }
    });

    function save() {

        postRequest(staffApiUrl, data, dataRes => {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Staff Created").then(() => $(location).attr('href', "/staffs"))
            } else {
                toastAlertInfo(dataRes.responseJSON.message);
            }
        })
    }

    function update() {
         // console.log(data);
        putRequest(staffApiUrl, data, response => {
            const jsonData = response.responseJSON;
            if (response.status === 200 && jsonData.statusCode === 200) {
                toastAlertSuccessBigNoBtn("Staff Updated").then(() => $(location).attr('href', "/staffs"))
            } else {
                toastAlertInfo(jsonData.message);
            }
        })
    }

    function selectBr(element, placeHolder, getDataUrl) {
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // Get Data for Select2
            com.forEach(d => {
                dataCom.push({id: d.branch_seq, text: d.name})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataCom
            });
        })
    }

    function selectPos(element, placeHolder, getDataUrl) {
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // Get Data for Select2
            com.forEach(d => {
                dataCom.push({id: d.pos_seq, text: d.pos_name})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataCom
            });
        })
    }

    function selectDeprt(element, placeHolder, getDataUrl) {
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // Get Data for Select2
            com.forEach(d => {
                dataCom.push({id: d.depart_seq, text: d.name})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataCom
            });
        })
    }

    function selectFile(element, id) {
        $(element).on("change", function() {
            var fileName = $(this).val().split("\\").pop();
            $(this).siblings(id).addClass("selected").html(fileName);
        });
    }

    let validExts = ["pdf", "doc","docx", "xlsx", "xls", "png", "jpg", "jpeg"];
    let logoImg;
    function validateAndAssignFile() {
        logoImg = $('#logo')[0].files[0];
        if (logoImg && logoImg.size > 0) {
            if(validExts.indexOf(logoImg.name.split('.').pop().toLowerCase()) >= 0){
                uploadFileFormData.append('files', logoImg);
                return true;
            } else {
                alert("File must be type " + validExts.toString() + " extension");
                return false;
            }
        }else { /* input file has not choose and no need to validate */
            toastAlertError("File has not chosen")
        }
    }

    function uploadFile(formData, func) {
        formDataPostRequest(uploadFileUrl, formData, async function (dataRes) {
            if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
                toastAlertSuccess("File upload successfully ");
                await func(dataRes.responseJSON.data);
            } else {
                let errorAlert = dataRes.responseJSON.message;
                toastAlertError(errorAlert);
            }
        }, false)
    }

    // function selectUser(element, placeHolder, getDataUrl) {
    //     let dataCom = [];
    //     let com = [];
    //     getRequest(getDataUrl, function (res) {
    //         // Get Data
    //         com = res.responseJSON.data;
    //         // Get Data for Select2
    //         com.forEach(d => {
    //             dataCom.push({id: d.user_seq, text: d.username})
    //         });
    //         // Set Data to Select2
    //         $(element).select2({
    //             placeholder: placeHolder,
    //             allowClear: true,
    //             data: dataCom
    //         });
    //     })
    // }
});
