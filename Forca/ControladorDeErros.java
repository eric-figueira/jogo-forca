public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		// verifica se qtdMax fornecida n�o � positiva, lan�ando
		// uma exce��o.
		// armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax < 0)
            throw new Exception("Quantidade máxima de erros inválida!");
        
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr == this.qtdMax)
            throw new Exception("Quantidade de erros já atingiu a quantidade máxima de erros!");
        
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent�o false, caso contrario.
        if (this.qtdErr == this.qtdMax)
            return true;
        
        return false;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeErros c = (ControladorDeErros) obj;
        if (this.qtdErr != c.qtdErr) return false;
        if (this.qtdMax != c.qtdMax) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 19;

        ret = 23 * ret + Integer.valueOf(qtdErr).hashCode();
        ret = 23 * ret + Integer.valueOf(qtdMax).hashCode();

        if (ret < 0 )
            ret = -ret;

        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if (c == null)
            throw new Exception("Modelo de classe ausente");
        
        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }

    public Object clone ()
    {
        // returnar uma c�pia de this
        ControladorDeErros c = null;
        try
        {
            c = new ControladorDeErros(this);
        }
        catch (Exception erro)
        {} // Sei que não vai dar erro

        return c;
    }
}
