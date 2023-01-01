import environment.IState;
import agents.AbstractSwarm;
import agents.SwarmHashMap;
import algorithms.*;
import referees.OnePlayerReferee;
import maabac.ArmN;
import maabac.Muscle;
import maabac.ElementaryMuscleEnvironment;
import maabac.MuscleFilter;

public class TestMaabac {

    public static void main(String argv[]) {
        int nbseg = 4;
        ArmN bras = new ArmN(nbseg, 0.5, 3.5, 0.2);
        AbstractSwarm essaim = new SwarmHashMap(bras);
        AbstractMemorySelector guru[] = new AbstractMemorySelector[2 * nbseg];
        int contr[] = new int[2 * nbseg];
        int maxi[] = new int[2 * nbseg];
        for (int i = 0; i < 2 * nbseg; i++) maxi[i] = 50;
        bras.setState(contr, maxi);
        IState depart = bras.defaultInitialState();
        for (int i = 0; i < 2 * nbseg; i++) {
            guru[i] = new QLearningSelector();
            guru[i].setBoltzmann();
            guru[i].setGamma(1.0);
            guru[i].setAlpha(0.1);
            guru[i].setGeometricAlphaDecay();
            guru[i].setDecay(1);
            guru[i].setTau(0.5);
            essaim.add(new Muscle(new ElementaryMuscleEnvironment(), guru[i], new MuscleFilter(i), depart));
        }
        OnePlayerReferee arbitre = new OnePlayerReferee(essaim);
        arbitre.setMaxIter(1000);
        arbitre.setGraphical();
        double total = 0.0;
        for (int i = 1; i < 100000; i++) {
            int u = arbitre.episode(depart);
            if (i == 10) arbitre.clearGraphical();
            total += u;
            if (i % 100 == 0) System.out.println(i + " " + u + " " + (total / (i + 0.0)));
            if (i == 5000) arbitre.setGraphical();
        }
    }
}
