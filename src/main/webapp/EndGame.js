/**
 * 
 */

var playerOneScore,playerOneName,playerTwoScore,playerTwoName;

  document.addEventListener('DOMContentLoaded', function() {
	// Make a GET request to the Servlet to get the board info
	fetch('/CarromApplicationWithJsAndServlet/PlayerOneScore')
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}
			return response.json();
		})
		.then(playerOneInfo => {
			console.log('In striker 2');
			playerOneScore=playerOneInfo.score;
			console.log('PlayerOneScore ' + playerOneScore);
			playerOneName=playerOneInfo.name;
			console.log('PlayerOneName ' + playerOneName);
				return fetch('/CarromApplicationWithJsAndServlet/PlayerTwoScore');
		})
		.then(response => response.json())
		.then(playerTwoInfo => {
			playerTwoScore=playerTwoInfo.score;
			console.log('PlayerTwoScore ' + playerTwoScore);
			playerTwoName=playerTwoInfo.name;
			console.log('PlayerTwoName ' + playerTwoName);
			if(playerOneScore > playerTwoScore) {
				document.getElementById('winner').innerText=playerOneName;
			} else if(playerTwoScore > playerOneScore) {
				document.getElementById('winner').innerText=playerTwoName;
			} else {
				document.getElementById('winner').innerText='Match Tied';
			}
			
		})
		.catch(error => {
			console.error('Error fetching player one info:', error);
		});
});;