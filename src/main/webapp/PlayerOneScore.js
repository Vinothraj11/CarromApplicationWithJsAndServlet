/**
 * 
 */

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
		//	console.log('Player1 Info name : ' + player1Info.name);
		//	console.log('Player1 score : ' + playerOneInfo.score);
			document.getElementById('playerOneName').innerText = playerOneInfo.name;
			document.getElementById('playerOneScore').innerText = playerOneInfo.score;
			document.getElementById('playerOneWhiteCoins').innerText = playerOneInfo.pocketedWhiteCoins;
			document.getElementById('playerOneBlackCoins').innerText = playerOneInfo.pocketedBlackCoins;
			document.getElementById('playerOneRedCoins').innerText = playerOneInfo.pocketedRedCoins;
		})
		.catch(error => {
			console.error('Error fetching player one info:', error);
		});
});;