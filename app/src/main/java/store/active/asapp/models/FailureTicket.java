package store.active.asapp.models;

public class FailureTicket {
    String pIva,ticketRequest;

    public FailureTicket(String _pIva, String _ticketRequest, String _context){
        this.pIva = _pIva;
        this.ticketRequest = _ticketRequest;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public String getTicketRequest() {
        return ticketRequest;
    }

    public void setTicketRequest(String ticketRequest) {
        this.ticketRequest = ticketRequest;
    }
}
