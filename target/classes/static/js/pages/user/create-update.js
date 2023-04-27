$(document).ready(function () {
    let data = {};
    let uploadFileFormData = {};
   const userApiUrl = "/api/v1/users";
   const brApiUrl = "/api/v1/branches";
   const posApiUrl = "/api/v1/positions";
   const departApiUrl = "/api/v1/departments";
   const uploadFileUrl = "/api/v1/softfiles/upload";
   const d = new Date();
   const month = d.getMonth() + 1;
   const day = d.getDate();

   const createDate = d.getFullYear() + '-' +
        (month < 10 ? '0' : '') + month + '-' +
        (day < 10 ? '0' : '') + day;

   const fullName = $("#fullName");
   const username = $("#username");
   const userNum = $("#userNum");
   const userType = $("#userType");
   const pwd = $("#pwd");
   const confPwd = $("#confPwd");
   const age = $("#age");
   const gender = $("#gender");
   const email = $("#email");
   const phone = $("#phone");
   const profile_img = $("#profile_img");
   const position = $("#position");
   const department = $("#department");
   const branch = $("#branch");

   selectPos("#position","-- Choose position --",posApiUrl);
   selectDepart("#department","-- Choose department --",departApiUrl);
   selectBr("#branch","-- Choose branch --",brApiUrl);
   selectFile("#proImg", "#imgFile");


   if(action === "update"){
       let posOpt = new Option(findNameAll.posname,findNameAll.posid, true, true);
       let departOpt = new Option(findNameAll.departname,findNameAll.departid, true, true);
       let brOpt = new Option(findNameAll.brname,findNameAll.brid, true, true);
       position.append(posOpt).trigger('change');
       department.append(departOpt).trigger('change');
       branch.append(brOpt).trigger('change');
   }

    function validateAndAssignData() {
       const posId = $('#position').select2('val');
       const departId = $('#department').select2('val');
       const brId = $('#branch').select2('val');

        let isValidate = validateInputField(
           [
               fullName,
               username,
               userNum,
               userType,
               pwd,
               confPwd
           ]
       );

       if (!isValidate) return false;

       if (pwd.val() !== confPwd.val()) {
           toastAlertInfo("Password not match");
           confPwd.focus();
           return false;
       }
       if (!userType){
           toastAlertInfo("Please select Type of User..!");
       }
       if (!posId){
           toastAlertInfo("Please select Position..!");
       }
       if (!departId){
           toastAlertInfo("Please select Department..!");
       }
       if (!brId){
           toastAlertInfo("Please select Branch..!");
       }

        data = {
           "fullName": fullName.val(),
           "username": username.val(),
           "password": pwd.val(),
           "userNum": userNum.val(),
           "userType": userType.val(),
           "age": age.val(),
           "gender": gender.val(),
           "email": email.val(),
           "phone": phone.val(),
           // "createDateTime": createDate.toString(),
           "createDateTime": createDate.toString(),
           "createId": 0,
           "updateDateTime": action === "update" ? createDate.toString() : '0',
           "updateId": 0,
           "logCount": 0,
           "posId": +posId,
           "brId": +brId,
           "departId": +departId,
           "enabled": true
       };
        /*Check if Upload Image*/
       let dirWithFileName = [];
       dirWithFileName.push("User");
       dirWithFileName.push(username.val());

       uploadFileFormData = new FormData();
       uploadFileFormData.append('dir', dirWithFileName);

       logoImg = $('#proImg')[0].files[0];
       if(logoImg !== undefined){
           if(validExts.indexOf(logoImg.name.split('.').pop().toLowerCase()) >= 0){
               uploadFileFormData.append('files', logoImg);
               uploadFile(uploadFileFormData, function (dataRes) {
                   data["proImg"] = dataRes[0].fileName;
                   data["proImgPath"] = dataRes[0].filePath;
               })
           } else {
               alert("File must be type " + validExts.toString() + " extension");
               return;
           }
       }

       return true;
   }

    $('#create').on('click',function() {
        if(validateAndAssignData()){
             // console.log(data);
            saveUser();
        }
    });

    $('#update').on('click',function() {
        validateAndAssignData();
        data['userSeq'] = userId.userSeq;
        updateUser();
    });

   function saveUser() {
       postRequest(userApiUrl, data, dataRes => {
           if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
               toastAlertSuccessBigNoBtn("User Created").then(() => $(location).attr('href', "/users"))
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

    function selectBr(element, placeHolder, getDataUrl) {
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // Get Data for Select2
            com.forEach(d => {
                dataCom.push({id: d.brSeq, text: d.name})
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
                dataCom.push({id: d.posSeq, text: d.posName})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataCom
            });
        })
    }

    function selectDepart(element, placeHolder, getDataUrl) {
        let dataCom = [];
        let com = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            com = res.responseJSON.data;
            // Get Data for Select2
            com.forEach(d => {
                dataCom.push({id: d.departseq, text: d.name})
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
            const fileName = $(this).val().split("\\").pop();
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
});
