angular.module('loginApp',[]).controller('mycontroller',['$scope','$http','$log',function($scope,$http,$log)
{
  this.name;
  this.password ;
  this.mail;
  this.gender ;
  this.age;
  this.score ;
   this.checkData=function()
   {
      ////////////////////// implement what happen 
      $http.post('http://localhost:8080/Student/Login/'+ this.password+'/' +this.name).then(function(response)
      {
        $scope.data=response.data;
       
        	this.name=response.data.name;
            this.password=response.data.password ;
            this.mail=response.data.mail;
            this.gender=response.data.gender ;
            this.age=response.data.age;
            this.score =response.data.score;
            $log.info(response.data.age);
            $log.info(response);
        
        
        
      } ,function(reason){$scope.error=reason.data ; $log.info(reason); } );

      
     
   }

    
}]);