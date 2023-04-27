$(document).ready(function () {

   const userApiUrl = "/api/v1/users";
   const userGroupApiUrl = "/api/v1/users-g";
   let data = {};
   const manager = $("#managerU");
   const member = $("#memberU");

   selectManager("#managerU","-- Choose manager --",userApiUrl);
   selectMember("#memberU","-- Choose member --",userApiUrl);
   const memberMulti = $('.js-example-basic-multiple').select2();


    function validateAndAssignData() {
        const managerId = $('#managerU').select2('val');
        const memberId = $('#memberU').select2('val');

        if (!managerId){
            toastAlertInfo("Please select the main...!");
        }
        if (!memberId){
            toastAlertInfo("Please select the member...!");
        }

        data = {
           "managerId": +managerId,
           "memberId": +memberMulti,
           "userId": +currentUser
       };
       return true;
   }

    $('#create').on('click',function() {
       if(validateAndAssignData()){
            console.log(data);
           // saveUser();
       }
        // console.log($('#memberU').select2('val'));

    });

    $('#update').on('click',function() {
        validateAndAssignData();
        data['user_seq'] = userId.user_seq;
        updateUser();
    });

   function saveUser() {
       postRequest(userGroupApiUrl, data, dataRes => {
           if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
               toastAlertSuccessBigNoBtn("User Group Created").then(() => $(location).attr('href', "/users-g"))
           } else {
               toastAlertInfo(dataRes.responseJSON.message);
           }
       })
   }

   function updateUser() {
       putRequest(userGroupApiUrl, data, dataRes => {
           if (dataRes.status === 200 && dataRes.responseJSON.statusCode === 200) {
               toastAlertSuccessBigNoBtn("User Group Updated").then(() => $(location).attr('href', "/users-g"))
           } else {
               toastAlertInfo(dataRes.responseJSON.message);
           }
       })
   }

    function selectManager(element, placeHolder, getDataUrl) {
        let dataUser = [];
        let user = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            user = res.responseJSON.data;
            // Get Data for Select2
            user.forEach(d => {
                dataUser.push({id: d.userSeq, text: d.username})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataUser
            });
        })
    }

    function selectMember(element, placeHolder, getDataUrl) {
        let dataUser = [];
        let user = [];
        getRequest(getDataUrl, function (res) {
            // Get Data
            user = res.responseJSON.data;
            // Get Data for Select2
            user.forEach(d => {
                dataUser.push({id: d.userSeq, text: d.username})
            });
            // Set Data to Select2
            $(element).select2({
                placeholder: placeHolder,
                allowClear: true,
                data: dataUser
            });
        })
    }

});
