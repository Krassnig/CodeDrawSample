const main = async () => {
	const downloadParticleGravityButton = document.getElementById('download-particle-gravity-button');
	const code = await fetch('./assets/ParticleGravity.java');
	downloadParticleGravityButton.addEventListener('click', () => {
		navigator.clipboard.writeText(code);
	});
}

main();