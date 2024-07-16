import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class Sorteio {

    private List<String> participantes;
    private Map<String, String> sorteados = new HashMap<>();

    public Sorteio(List<String> participantes) {
        this.participantes = participantes;
    }
    public void sortear() {
        if (participantes.isEmpty()) {
            return;
        }
        Collections.shuffle(participantes);

        for (int i = 0; i < participantes.size() - 1; i += 2) {
            String presenteador = participantes.get(i);
            String presenteado = participantes.get(i + 1);

            sorteados.put(presenteador, presenteado);

            System.out.println(presenteador + " -> " + presenteado);
        }

        participantes.remove(participantes.size() - 1); // Remove o último participante
        if (participantes.size() % 2 != 0) { // Se sobrar 1 participante, remova-o também
            participantes.removeFirst();
        }
    }


}
