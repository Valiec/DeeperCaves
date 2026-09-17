package com.kpabr.DeeperCaves;

public class CommonProxy {

        // Client stuff
        public void registerRenderers() {
           
                // Nothing here as the server doesn't render graphics or entities!
        }

        public void spawnVibrationParticle(double xSrc, double ySrc, double zSrc, double xDest, double yDest, double zDest, double speed) {
                //client only
        }

        public void spawnShriekParticle(double xSrc, double ySrc, double zSrc) {
                //client only
        }
}