import java.time.LocalDate

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class MatriculaIlegal(val msg: String): Throwable (msg)

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val descricao: String)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: List<ConteudoEducacional>, val inicioFormacao: LocalDate, val finalFormacao: LocalDate  ) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if(usuario.nivel == nivel){
        	inscritos.add(usuario)
        } else {
            throw MatriculaIlegal("Usuario com nivel inferior ao do curso ministrado.");
        }
    }
    
    fun cargaHorariaTotal(): Int {
        return conteudos.sumOf {it.duracao}
    }
    
    fun quantidadeDeInscritos(): Int{
        return inscritos.size
    }
    
    override fun toString():String {
        return """ 
            FORMAÇÃO: ${nome}
            CARGA HORARIA TOTAL: ${cargaHorariaTotal()}
            CURSOS OFERECIDOS: ${conteudos}
            ALUNOS MATRICULADOS: ${quantidadeDeInscritos()}
        """
    }
}

fun main() {
    val user1 = Usuario("Lucas Ilussencio", Nivel.BASICO)
    val user2 = Usuario("Maria de Lourdes", Nivel.INTERMEDIARIO)
    val user3 = Usuario("Patricia Santiago", Nivel.DIFICIL)
    
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 50, "Aprenda Kotlin com exemplos")
    val conteudo2 = ConteudoEducacional("Orientação a objetos com Kotlin", 50, "Aprenda Orientação a objetos com kotlin")
    val conteudo3 = ConteudoEducacional("Tratamento de exeções com Kotlin", 50, "Aprenda a tratar execeções com a linguagem de programação Kotlin com exemplos")
    
    val formacao1 = Formacao (
        "Aprenda o basio da linguagem Kotlin",
        Nivel.BASICO,
        listOf(conteudo1,conteudo2),
        LocalDate.of(2023,11,23),
        LocalDate.of(2024,1,1)
    )
    
    val formacao2 = Formacao (
        "Curso completo de Kotlin",
        Nivel.DIFICIL,
        listOf(conteudo1,conteudo2,conteudo3),
        LocalDate.of(2023,11,23),
        LocalDate.of(2024,1,1)
    )
    
    try {
        formacao1.matricular(user1)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    
    try {
        formacao1.matricular(user2)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    try {
        formacao1.matricular(user3)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    
    try {
        formacao2.matricular(user1)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    
    try {
        formacao2.matricular(user2)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    try {
        formacao2.matricular(user3)
    }catch(e: MatriculaIlegal) {
        println("Erro ao matricular")
    }
    
    println(formacao1.toString())
    println(formacao2.toString())
    
}