var app = angular.module('app', []);

	app.controller('welcomeCtrl', function($scope,$http,$window) {
    
    init();
    function init() {
       
    }
 	
	var storedData = localStorage.getItem('loginData');
	    
	    if (storedData) {
	        $scope.data = JSON.parse(storedData);
	    } else {
	        console.error('No data found in localStorage');
	        $window.location.href = "/BTS/login"; 
	    }

// Function to show details in modal
    $scope.showDetails = function(ticket) {
        $scope.selectedTicket = ticket;
        $('#detailsModal').modal('show');
    };
    
    
		

		});

