    angular.module('app', ['ui.router'])
    'use strict';

    var app = angular.module('app', ['ui.router']).factory('AuthInterceptor', [function () {
      return {
        // Send the Authorization header with each request
        'request': function (config) {
          config.headers = config.headers || {};
          var encodedString = btoa("admin:admin");
          config.headers.Authorization = 'Basic ' + encodedString;
          return config;
        }
      };
    }]);

    // app.config(['$httpProvider', function ($httpProvider) {
    //     $httpProvider.interceptors.push('AuthInterceptor');
    // }]);


    app.config(['$httpProvider', '$stateProvider', function ($httpProvider, $stateProvider) {
      $stateProvider
        .state('GradesData', {
          url: '/GradesData',
          templateUrl: 'GradesData.html'
        })
        .state('GradesForm', {
          url: '/GradesForm',
          templateUrl: 'GradesForm.html'
        })

      $httpProvider.interceptors.push('AuthInterceptor');

    }]);




    app.factory("myFactory", function () {
      var savedData = {}

      function set(data) {
        savedData = data;
      }

      function get() {
        return savedData;
      }

      return {
        set: set,
        get: get
      }
    })


    app.controller('ctrl', function ($scope, $http, $location, myFactory) {
      refreshGradesData();

      $scope.gradesForm = {
        gId: -1,
        mcId: "",
        gName: "",
        gDetails: "",
        status: "active",
        lastModified: ""
      };


      function refreshGradesData() {
        $http.get("http://localhost:8080/VRProject/webservice/grades").then(function mySuccess(
          response) {
          $scope.grades = response.data.grades;

        }, function myError(response) {});

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
      };

      //HTTP DELETE- delete country by Id
      $scope.deleteGrades = function (grades) {
        $http({
          method: 'DELETE',
          url: 'webservice/grades/' + grades.gId
        }).then(_success, _error);
      };

      function _success(response) {
        refreshGradesData();

      }

      function _error(response) {
        console.log(response.statusText);
      }

      $scope.sort = function (keyname) {
        $scope.sortKey = keyname; //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
      }

      $scope.editGrades = function (x) {

        $scope.gradesForm.gId = x.gId;;
        $scope.gradesForm.mcId = x.mcId;
        $scope.gradesForm.gName = x.gName;
        $scope.gradesForm.gDetails = x.gDetails;
        $scope.gradesForm.status = x.status;
        $scope.gradesForm.lastModified = x.lastModified;
        myFactory.set(x);
        $location.path('GradesForm');

      }



    });