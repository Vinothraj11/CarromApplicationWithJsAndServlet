/**
 * 
 */

  document.addEventListener('DOMContentLoaded', function() {
	// Make a GET request to the Servlet to get the board info
	fetch('/CarromApplicationWithJsAndServlet/PlayerTwoScore')
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}
			return response.json();
		})
		.then(playerTwoInfo => {
		//	console.log('Player1 Info name : ' + player1Info.name);
			console.log('Player2 score : ' + playerTwoInfo.score);
			document.getElementById('playerTwoName').innerText = playerTwoInfo.name;
			document.getElementById('playerTwoScore').innerText = playerTwoInfo.score;
			document.getElementById('playerTwoWhiteCoins').innerText = playerTwoInfo.pocketedWhiteCoins;
			document.getElementById('playerTwoBlackCoins').innerText = playerTwoInfo.pocketedBlackCoins;
			document.getElementById('playerTwoRedCoins').innerText = playerTwoInfo.pocketedRedCoins;
		})
		.catch(error => {
			console.error('Error fetching player1 info:', error);
		});
});;