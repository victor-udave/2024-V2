package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.IndexerRollers;

public class IndexerOutPass extends Command { //comando para que pase al shooter
  private IndexerRollers rollers; //crea variable rollers del subsistema IndexRollers

  public void IndexIn(IndexerRollers rollers) {
    this.rollers = rollers; // permite que la clase tenga acceso a este subsistema
    addRequirements(rollers); //deja que otros comandos que utilizen rollers puedan usarse pero le da prioridad a este cuando se usa
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() { //siempre
    rollers.setRollersOutReceivingSpeed(); // pone los rollers a la velocidad que estableciste previamente para cuando los rollers agarran
  }

  @Override
  public void end(boolean interrupted) { // al final del comando
    rollers.setRollersOutSpeed(0);
  }

  @Override
  public boolean isFinished() { //cuando el comando acabe
    return false;// regresa que si los rollers tienen pieza o no
  }
}
