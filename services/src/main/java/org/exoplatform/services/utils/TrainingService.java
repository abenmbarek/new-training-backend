package org.exoplatform.services.utils;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class TrainingService {
    private static final Log LOG = ExoLogger.getLogger(TrainingService.class);

    public TrainingService(){
        LOG.info("Service training created successfully !");

    }

    public void onStart(){
        LOG.info("START : Service training started successfully !");

    }

    public void onStop(){
        LOG.info("STOP : Service training stopped successfully !");

    }
}
