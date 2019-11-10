
package ohtu.verkkokauppa;

public class VarastotoimiIO implements VarastoIO {
    
    private Varasto varasto;
    
    public VarastotoimiIO(Varasto varasto) {
        this.varasto = varasto;
    }
    
    @Override
    public Tuote haeTuote(int id) {
        return this.varasto.haeTuote(id);
    }
    
    @Override
    public void palautaVarastoon(Tuote t) {
        this.varasto.palautaVarastoon(t);
    }
    
    @Override
    public int saldo(int id) {
        return this.varasto.saldo(id); 
    }
    
    @Override
    public void otaVarastosta(Tuote t) {
        this.varasto.otaVarastosta(t);
    }
    
    
}
