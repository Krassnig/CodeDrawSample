const main = () => {
	bindButtonToCode('download-particle-gravity-button', './assets/particle-gravity/ParticleGravity.java');
	bindButtonToCode('download-game-of-life-button', './assets/game-of-life/GameOfLife.java');
}

const bindButtonToCode = async (buttonId, fileName) => {
	const button = document.getElementById(buttonId);
	const fileContents = await fetch(fileName);
	button.addEventListener('click', () => {
		navigator.clipboard.writeText(fileContents);
	})
}

main();