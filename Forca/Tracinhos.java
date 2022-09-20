public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd n�o � positiva, lan�ando uma exce��o.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).
        if (qtd < 0)
            throw new Exception("Tamanho de vetor inválido");
        
        this.texto = new char[qtd];
        
        for (int pos = 0; pos < qtd; pos++)
            this.texto[pos] = '_';
    }

    public void revele (int posicao, char letra) throws Exception
    {
		// verifica se posicao � negativa ou ent�o igual ou maior
		// do que this.texto.length, lan�ando uma exce��o.
		// armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto
        if (posicao < 0 || posicao >= this.texto.length)
            throw new Exception("Posicao de revelação inválida!");
        
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
        for (short i = 0; i < this.texto.length; i++)
        {
            if (this.texto[i] == '_')
                return true;
        }
    
        return false;
    }

    public String toString ()
    {
        // retorna um String com TODOS os caracteres que h�
        // no vetor this.texto, intercalados com espa�os em
        // branco
        String ret = "";
        for (short pos = 0; pos < this.texto.length; pos++)
            ret += this.texto[pos] + " ";
        
        return ret;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        
        Tracinhos t = (Tracinhos) obj;
        if (!this.texto.equals(t.texto)) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 19;
        ret = 23 * ret + this.texto.hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conte�do de t.texto para this.texto
        if (t == null)
            throw new Exception("Modelo de classe inválido!");

        this.texto = new char[t.texto.length];
        for (short pos = 0; pos < t.texto.length; pos++)
            this.texto[pos] = t.texto[pos];
    }

    public Object clone ()
    {
        // retornar uma copia de this
        Tracinhos t = null;
        try
        {
            t = new Tracinhos(this);
        }
        catch (Exception erro)
        {} // Sei que não vai dar erro

        return t;
    }
}
