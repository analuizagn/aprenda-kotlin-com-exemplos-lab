enum class Nivel {
    BÁSICO,
    INTERMEDIÁRIO,
    AVANÇADO
}

class Usuario(val nome: String, val email: String) {
}

data class ConteudoEducacional(val nome: String, val duracao: Int) {
    
    val usuariosMatriculados: MutableList<Usuario> = mutableListOf()

    fun matricularUsuario(usuario: Usuario) {
        usuariosMatriculados.add(usuario)
        println("${usuario.nome} foi matriculado(a) no conteúdo educacional: $nome")
    }

    fun listarUsuariosMatriculados() {
        println("Usuários matriculados no conteúdo educacional $nome:")
        for (usuario in usuariosMatriculados) {
            println("- ${usuario.nome}")
        }
    }
}

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    
    fun listarConteudosEducacionais() {
        println("Conteúdos educacionais da formação $nome nível $nivel:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} - ${conteudo.duracao}hrs")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 1)
    val conteudo2 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 2)
    
    val formacao1 = Formacao("Desenvolvimento Backend com Kotlin", Nivel.BÁSICO, listOf(conteudo1, conteudo2))

    val usuario1 = Usuario("Ana", "ana@gmail.com")
    val usuario2 = Usuario("Luiza", "luiza@gmail.com")

    conteudo1.matricularUsuario(usuario1)
    conteudo2.matricularUsuario(usuario2)
    
    conteudo1.listarUsuariosMatriculados()
    conteudo2.listarUsuariosMatriculados()

    formacao1.listarConteudosEducacionais()
}