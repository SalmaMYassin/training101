	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope, $http){

		$scope.all = function(){
			$http.get("http://localhost:8080/anotherOne/app/tasks/all")
			.then(function(response) {
				$scope.items = response.data;
				$scope.setActive(0);
			})
		}

		$scope.add = function(){
			var dataObj = {
				task: $scope.item
			}
			$http.post('http://localhost:8080/anotherOne/app/tasks/add',dataObj)
			.then(function(response){
				$scope.all();
			})
			$('#id').val('');

			// $http.post("http://localhost:8080/Trial/Trial/tasks/add", JSON.stringify($scope.item))
			//       .then(function (response){
			//     		// console.log($scope.item);
			//     	};
			//push to the back end http.post
		    // $scope.items.push({task:$scope.item, done:false});
		}

		$scope.remove = function(){
			// send a request to the backend to remove all done tasks
			
			$http.get('http://localhost:8080/anotherOne/app/tasks/deletedone/'
				).then(function(response) {
					$scope.all();
				});
			}
			
			$scope.setDone = function(item){
				$http.get('http://localhost:8080/anotherOne/app/tasks/done/'+ item);
			}

			$scope.removeItem = function(id){

				if (confirm("Are you sure you want to delete this task?")) {
					$http.get('http://localhost:8080/anotherOne/app/tasks/delete/'+ id
						).then(function(response) {
							$scope.all();
						});
					} 

		//send the task name or index to backend to remove it from the list	
	}

	$scope.setActive = function(index) {
		$scope.activeIndex = index;
		$scope.activeMenu = JSON.parse(JSON.stringify($scope.items[index]));
		if($scope.activeMenu.due != null){
			var newDate=$scope.activeMenu.due.toString().replace("/","-");
			$scope.activeMenu.due = new Date(newDate);
			// console.log($scope.activeMenu.due);
		}
		var taskTitle = $('#task-title');
		taskTitle.focus();
	}

	$scope.save = function() {
			// $scope.activeMenu.$due = $scope.activeMenu.$due.toUTCString();
			var dataObj = $scope.activeMenu;
			// console.log(new Date(dataObj.due).toLocaleDateString());
			$http.post('http://localhost:8080/anotherOne/app/tasks/update/' + $scope.activeMenu.id, dataObj)
			.then(function(response){
				$scope.all();
				alert("Task Saved!");
			});
		}

	});

	//https://www.youtube.com/watch?v=aGHzqwQU06g