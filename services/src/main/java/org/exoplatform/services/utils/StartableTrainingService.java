package org.exoplatform.services.utils;
import org.picocontainer.Startable;

public class StartableTrainingService implements Startable {


    private TrainingService ts ;

    public StartableTrainingService(TrainingService ts ) {
       this.ts = ts;
    }

    @Override
    public void start() {
        ts.onStart();
    }

    @Override
    public void stop() {
       ts.onStop();

    }
}
