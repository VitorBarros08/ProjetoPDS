package exceptions;

public class InexistentSectorException extends Exception
{
	public InexistentSectorException()
	{
        super();
	}

	public InexistentSectorException(String message)
	{
        super(message);
	}
}
