var extScope;
app
    .controller('grades', function ($scope, $http,  myFactory) {


        $scope.grades = myFactory.get();

        
        extScope = $scope;
        $scope.materialcategories = [];
        $scope.gradesForm = {
            gId: -1,
            mcId: "",
            gName: "",
            gDetails: "",
            status: "",
            lastModified: ""
        };
        refreshGradesData();

        function refreshGradesData() {
            if ($scope.grades.gId == null) {
                $scope.repeatSelect = 3;
                $http
                    .get(
                        "../VRProject/webservice/materialcategories")
                    .then(
                        function mySuccess(response) {
                            $scope.materialcategories = response.data.materialcategories;
                        },
                        function myError(response) {});

            } else {
                $scope.repeatSelect = $scope.grades.mcId;

                $http
                    .get(
                        "../VRProject/webservice/grades/" + $scope.grades.gId)
                    .then(
                        function mySuccess(response) {
                            $scope.gradesForm = response.data;
                            $scope.repeatSelect = $scope.gradesForm.mcId;
                            alert($scope.repeatSelect);

                        },
                        function myError(response) {});
                $http
                    .get(
                        "../VRProject/webservice/materialcategories")
                    .then(
                        function mySuccess(response) {
                            $scope.materialcategories = response.data.materialcategories;
                        },
                        function myError(response) {});

            }
        }

        $scope.submitGrades = function () {

            var method = "";
            var url = "";
            if ($scope.gradesForm.gId == -1) {
                //Id is absent in form data, it is create new country operation
                method = "POST";
                url = 'webservice/grades';
            } else {
                //Id is present in form data, it is edit country operation
                method = "PUT";
                url = 'webservice/grades';
            }

            $http({
                method: method,
                url: url,
                data: angular.toJson($scope.gradesForm),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(_success, _error);
        }

        function _success(response) {
            refreshGradesData();
            _clearFormData()
        }

        function _error(response) {
            console.log(response.statusText);
        }

        //Clear the form
        function _clearFormData() {
            $scope.gradesForm.gId = -1;
            $scope.gradesForm.mcId = "";
            $scope.gradesForm.gName = "";
            $scope.gradesForm.gDetails = "";
            $scope.gradesForm.status = "active";
            $scope.gradesForm.lastModified = "";
            document.getElementById("r1").checked = true;
        };

    });