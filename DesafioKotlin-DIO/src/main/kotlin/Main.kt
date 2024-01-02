enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

class User(val nome: String, val id: Long, var formacao: Formacao? = null)

data class ConteudoEducacional(var nome : String, val duracao : Int = 60)

data class Formacao(val nome: String, var conteudos: ConteudoEducacional, val nivel: Nivel)


val inscritos = mutableListOf<User>()

fun matricular(user: User, formacao: Formacao?) {
    inscritos.add(user)
    user.formacao = formacao
    if (formacao != null) {
        println("${user.nome} matriculado com sucesso na formação: ${formacao.nome}, de nível: ${formacao.nivel}")
    } else {
        println("${user.nome} não possui formação matriculada.")
    }
}

fun main(){
    val user1 = User("Carlos Fernandino", 1)
    val user2 = User("Lucas Santos", 2)
    val user3 = User("Vinicius",3)

    val kotlin = ConteudoEducacional("Desenvolvimento BackEnd em Kotlin", 52)
    val etlPython = ConteudoEducacional("Análise de dados com Python", 92)

    val formacaoKotlin = Formacao("Desenvolvimento BackEnd em Kotlin", kotlin, Nivel.INTERMEDIARIO)
    val formacaoEtlPython = Formacao("Análise de dados com Python", etlPython, Nivel.AVANCADO)

    matricular(user1, formacaoKotlin)
    matricular(user2, formacaoEtlPython)
    matricular(user3, formacao = null)
}

