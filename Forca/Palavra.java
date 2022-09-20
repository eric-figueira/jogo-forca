public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.
        if (texto.trim() == "" || texto == null)
            throw new Exception("Palavra passada é inválida!");
        
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        short qtdLetrasIguais = 0;
        for (short i = 0; i < this.texto.length(); i++)
            if (this.texto.charAt(i) == letra)
                qtdLetrasIguais++;
        
        return qtdLetrasIguais;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.
        short aparicoesDaLetra = 0;
        for (short pos = 0; pos < this.texto.length(); pos ++)
        {
            if (this.texto.charAt(pos) == letra)
                aparicoesDaLetra++;
            
            if (aparicoesDaLetra == i + 1)
                return pos;
        }
        throw new Exception("Posicao da iezima ocorrencia não encontrada!");

    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Palavra p = (Palavra) obj;
        if (!this.texto.equals(p.texto)) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 19;
        ret = 23 * ret + String.valueOf(this.texto).hashCode();

        if (ret < 0)
            ret = -ret;
        
        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
