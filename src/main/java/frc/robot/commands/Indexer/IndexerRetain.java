package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.IndexerRollers;

public class IndexerRetain extends Command {
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
     if (rollers.hasPieceIn() && !rollers.hasPieceMiddle()){
        rollers.setRollersInRetainSpeed();
        rollers.setRollersOutSpeed(0);
    } else if (!rollers.hasPieceIn() && rollers.hasPieceMiddle()){
        rollers.setRollersOutRetainSpeed();
        rollers.setRollersInSpeed(0);
    } else if (rollers.hasPieceIn() && rollers.hasPieceMiddle()){
        rollers.stop();
    } else {
        rollers.stop();
    }
  }

  @Override
  public void end(boolean interrupted) { // al final del comando
    rollers.stop();
  }

  @Override
  public boolean isFinished() { //cuando el comando acabe
    return rollers.hasPieceRetained();// regresa que si ambos sensores estan tocando la nota
  }
}
