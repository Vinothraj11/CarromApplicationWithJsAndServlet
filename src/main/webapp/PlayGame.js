/**
 * 
 */

var striker;
var isRedCoinPocketed;
var playerName;

document.addEventListener('DOMContentLoaded', function() {
	// Make a GET request to the Servlet to get the board info
	fetch('/CarromApplicationWithJsAndServlet/BoardStatusServlet')
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}
			return response.json();
		})
		.then(boardInfo => {
			console.log('Getting striker value from board api ' + boardInfo.striker);
			striker = boardInfo.striker;
			isRedCoinPocketed = boardInfo.isRedCoinPocketed;
			if(isRedCoinPocketed) {
				redCoinOption.style.display = 'none';
			}
			if(striker == 1) {
				console.log('In striker 1');
				return fetch('/CarromApplicationWithJsAndServlet/PlayerOneScore');
			} else {
				console.log('In striker 2');
				return fetch('/CarromApplicationWithJsAndServlet/PlayerTwoScore');
			}
		})
		.then(response => response.json())
		.then(playerInfo => {
			console.log('Name ' + playerInfo.name);
			playerName = playerInfo.name;
			document.getElementById('playerName').innerText += playerName;
		})
		.catch(error => {
			console.error('Error fetching board info:', error);
		});
});;

document.getElementById('carromForm').addEventListener('submit', function(event) {
	event.preventDefault();
	var selectedAction = document.getElementById('action').value;
	console.log('selectedAction ' + selectedAction);
	var url = '/CarromApplicationWithJsAndServlet/CarromBoardServlet?action='+selectedAction;
	console.log('url1 ' + url);
	fetch(url,{
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: '',
	})
	.then(response => {
		if (!response.ok) {
                        throw new Error(`HTTP error! Status: ${response.status}`);
                    }
                    return response.text();
	})
	.then(redirectUrl => {
		console.log('Redirect Url ' + redirectUrl);
		window.location.href = redirectUrl;
	})
	.catch(error => {
		console.error('Error fetching data from CarromBoardServlet:', error);
	});
});