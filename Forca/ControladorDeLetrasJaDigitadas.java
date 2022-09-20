public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        for (short pos = 0; pos < this.letrasJaDigitadas.length(); pos++)
            if (this.letrasJaDigitadas.charAt(pos) == letra)
                return true;
        
        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.
        if (isJaDigitada(letra))
            throw new Exception("Falha ao registrar a letra: letra já digitada");
        
        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).
        String ret = "";
        if (this.letrasJaDigitadas.length() > 0)
        {
            for (short pos = 0; pos < this.letrasJaDigitadas.length() - 1; pos++)
                ret += this.letrasJaDigitadas.charAt(pos) + ", ";
            
            ret += this.letrasJaDigitadas.charAt(this.letrasJaDigitadas.length() - 1);
        }

        return ret;

    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;
        if (!this.letrasJaDigitadas.equals(c.letrasJaDigitadas)) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 29;

        ret = 23 * ret + String.valueOf(this.letrasJaDigitadas).hashCode();

        if (ret < 0)
            ret = -ret;
        
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas == null)
            throw new Exception("Modelo de classe inválido");
        
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        ControladorDeLetrasJaDigitadas c = null;
        try
        {
            c = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro)
        {} // Sei que não vai dar erro

        return c;
    }
}
