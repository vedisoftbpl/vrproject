angular.module('app').factory('AuthInterceptor', [function() {  
    return {
    // Send the Authorization header with each request
        'request': function(config) {
            config.headers = config.headers || {};
            var encodedString = btoa("admin:admin");
            config.headers.Authorization = 'Basic '+encodedString;
           return config;
        }
    };
}]);