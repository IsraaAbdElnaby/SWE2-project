//alert("Failed to load resource:");

var app=angular.module('app',['ngRoute','mycontroller','dashBoard']);


app.controller('MainController', function($scope, $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
    
    $http.post('js/home/dashBoard/dashBoard.html').then(function(res){
    	console.log('res.data'); 
    }
)});



app.config(['$routeProvider',['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
    $routeProvider
   /* .when('/knowledgeplus',{
         templateUrl : '/index.html'
    })*/
    .when('about',{
         templateUrl : 'about.html'
    })
  /*  .when('knowledgeplus',{
         templateUrl : '/public/index.html'
    })*/
    .when('/Dashboard',{
         templateUrl : "@{js/home/dashBoard/dashBoard.html}",
         controller:'dashboardController',
         css:{href:"js/home/style2.css"}
    })
    
     .when('/home',{
         templateUrl : "@{js/home/account.html}",
         css:{href:"js/home/style2.css"}
         //controller:'dashboardController'
    })
    
     .when('login',{
       /*  templateUrl : "@{/templates/login.html}",*/
    	 templateUrl : "@{js/login/login.html}",
         controller:'mycontroller',
         css:{th:href="@{js/login/style.css}"}
    })
    
    .when('signUp',{
    	
        templateUrl:'/templates/signUpForm.html',
    	controller:'MainController',
    	css:{href:"css/signupForm.css"}
    		
    })



    .otherwise({redirectTo : '/'})

  $locationProvider.html5Mode(true);

}]]);



/*app.config(['$locationProvider',function($locationProvider){
	$locationProvider.hashPrefix('');
}]);*/

app.controller("homeController",['$scope','$location',function($scope,$location){
	/*$scope.redirect = function(hash){
		  $location.path (hash);
		};*/
		
		$scope.go = function ( path ) {
			  $location.path( path );
			};

}]);

        app.controller('users',['$scope','&http',function users($scope,$http){
          $http.get('js/data.json').success(function(data){
                  $scope.userData=data;
          });
          }]);

app.directive('backImg',function(){
	return function(scope,element,attrs){
		var url=attrs.backImg;
		element.css({
			'background-image':'url('+url+')',
			'background-size':'cover'
		});
	};
});

app.directive("signInDirective",function(){
	return{
		templateUrl:'static/templates/login.html'
	}
}); 

