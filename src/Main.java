import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.*;


class Main {
    static List<Estudiante>estudiantes;
    public static void main(String[] args) throws IOException {
        cargarArchivo();
        System.out.println("----------------------");
        System.out.println("aspirantes por carrera");
        System.out.println("----------------------");
        aspirantes_por_carrera();
        System.out.println("----------------------");
        System.out.println("total mujeres por carrera");
        System.out.println("----------------------");
        total_mujeres_por_carrera();
        System.out.println("----------------------");
        System.out.println("total hombres por carrera");
        System.out.println("----------------------");
        total_hombres_por_carrera();
        System.out.println("----------------------");
        System.out.println("puntaje matematicas mas alto por carrera");
        System.out.println("----------------------");
        puntajeMatematicasMasAltoPorCarrera();
        System.out.println("----------------------");
        System.out.println("puntaje matematicas mas alto de todos");
        System.out.println("----------------------");
        PuntajeMatematicasMasAltoDeTodos();
        System.out.println("----------------------");
        System.out.println("puntaje promedio por carrera");
        System.out.println("----------------------");
        puntajePromedioPorCarrera();


    }
    static void cargarArchivo() throws IOException{
        Pattern pattern =Pattern.compile(",");
        String filename= "student-scores.csv";

        try(Stream<String> lines = Files.lines(Path.of(filename))){
            estudiantes=lines.skip(1).map(line->{
                String[]arr=pattern.split(line);
                return new Estudiante(arr[0],arr[1],arr[2],arr[4],arr[9],Integer.parseInt(arr[10]));
            }).collect(Collectors.toList());
            estudiantes.forEach(System.out::println);
        }
    }
    static void aspirantes_por_carrera(){
        Map<String,Long> aspirantes_por_carrera=estudiantes.stream()
                .collect(Collectors.groupingBy(Estudiante::getCarrera_a_estudiar,Collectors.counting()));
        aspirantes_por_carrera.forEach((carrera,cantidad)->System.out.println(carrera+" "+cantidad));
    }
    static void total_mujeres_por_carrera(){
        Map<String,Long> total_mujeres_por_carrera=estudiantes.stream()
                .filter(estudiante -> estudiante.getGenero().equals("female")).
                collect(Collectors.groupingBy(Estudiante::getCarrera_a_estudiar,Collectors.counting()));
        total_mujeres_por_carrera.forEach((carrera,cantidad)->System.out.println(carrera+" "+cantidad));
    }
    static void total_hombres_por_carrera(){
        Map<String,Long> total_hombres_por_carrera = estudiantes.stream().
                filter(estudiante -> estudiante.getGenero().equals("male")).
                collect(Collectors.groupingBy(Estudiante::getCarrera_a_estudiar,Collectors.counting()));
        total_hombres_por_carrera.forEach((carrera,cantidad)->System.out.println(carrera+" "+cantidad));
    }
    static void puntajeMatematicasMasAltoPorCarrera(){
        Map<String,Integer> puntajeMatematicasMasAltoPorCarrera = estudiantes.stream()
                .collect(Collectors.groupingBy(Estudiante::getCarrera_a_estudiar,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Estudiante::getPuntaje_matematicas)),estudiante->estudiante.get().getPuntaje_matematicas())));
        puntajeMatematicasMasAltoPorCarrera.forEach((carrera,cantidad)->System.out.println(carrera+" "+cantidad));
    }

    static void PuntajeMatematicasMasAltoDeTodos() {
        Estudiante estudianteConMejorPuntaje = estudiantes.stream()
                .max(Comparator.comparing(Estudiante::getPuntaje_matematicas))
                .get();

        System.out.println(estudianteConMejorPuntaje);
    }
    static void puntajePromedioPorCarrera() {
        Map<String, Double> puntajePromedioPorCarrera = estudiantes.stream()
                .collect(Collectors.groupingBy(Estudiante::getCarrera_a_estudiar,
                        Collectors.averagingInt(Estudiante::getPuntaje_matematicas)));

        puntajePromedioPorCarrera.forEach((carrera, promedio) -> System.out.println(carrera + ": " + promedio));
    }
}
