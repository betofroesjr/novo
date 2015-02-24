package com.util.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GerarTarefasAgendadas {

    Timer timer;
    /**
     * Método para iniciar a execução das tarefas.
     */
    public void iniciar() {

        timer = new Timer();
        //Executa tarefa a cada 24 horas a partir da primeira
        //       timer.schedule(new tarefasDiarias(),
        //        0,
        //        1 * 1000 * 60 * 60 * 24);

        //Executa tarefa todo dia as 6 da manha
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 27);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        timer.schedule(new tarefasDiarias(), time);
    }
    /**
     * Método para interromper a execução das tarefas.
     */
    public void parar() {
        timer.cancel();
    }
    /**
     * Método que contém as tarefas agendadas que serão executadas.
     */
    class tarefasDiarias extends TimerTask {

        public void run() {
            System.out.println("Que bosta deu certo");
        }
    }
}
