var app = angular.module('app', []);

app.controller('LoginCtrl', function($scope, $http, $window, $timeout) {

    init();
    function init() {}

    $scope.credentials = {
        username: '',
        password: ''
    };

    $scope.userLogin = function() {
        var authHeader = 'Basic ' + btoa($scope.user.userName + ':' + $scope.user.password);

        $http({
            method: 'POST',
            url: '/BTS/app/login',
            headers: {
                'Authorization': authHeader
            },
            withCredentials: true
        }).then(function(response) {
            if (response.status == 200) {
                // Login successful
                localStorage.setItem('loginData', JSON.stringify(response.data));

                // Show success message
                $scope.successMessage = "Login successful! Redirecting...";
                $scope.errorMessage = "";  // Clear any previous error message
                
                // Delay redirection by 3 seconds
                $timeout(function() {
					console.log(response);
                    $window.location.href = "/BTS/welcome";
                }, 1000);

            } else {
                // Invalid credentials
                $scope.errorMessage = "Invalid credentials. Please try again.";
                $scope.successMessage = "";  // Clear any success message
                document.getElementById("credential").classList.remove('d-none');
            }
        }, function(error) {
            // Show error message for failed login
            $scope.errorMessage = "Login failed. Please check your credentials and try again.";
            $scope.successMessage = "";  // Clear any success message
        });
    };

    $scope.logout = function() {
        localStorage.removeItem('loginData');
        $window.location.href = "/BTS/login";
    };
});
