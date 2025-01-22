package logistics.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import logistics.demo.model.Transporter;
import logistics.demo.repository.TransporterRepository;

@Service
public class TransporterService {

    private final TransporterRepository transporterRepository;

    public TransporterService(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    //GET all
    public List<Transporter> getAllTransporters() {
        return transporterRepository.findAll();
    }

    //GET by id
    public Transporter getTransporterById(Long id) {
        return transporterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transportador não encontrado!"));
    }

    //POST
    public Transporter createTransporter(Transporter transporter) {
        transporter.setDataCriacao(LocalDateTime.now());
        transporter.setDataAlteracao(LocalDateTime.now());

        return transporterRepository.save(transporter);
    }

    //UPDATE
 public Transporter updateTransporter(Long id, Transporter transporter) {
    // Busca o transportador existente pelo ID
    Transporter existingTransporter = getTransporterById(id);

    // Copia as propriedades do transportador recebido para o existente (exceto o ID e datas)
    BeanUtils.copyProperties(transporter, existingTransporter, "id", "dataCriacao", "dataAlteracao");

    // Atualiza a data de alteração
    existingTransporter.setDataAlteracao(LocalDateTime.now());

    // Salva no banco de dados e retorna o transportador atualizado
    return transporterRepository.save(existingTransporter);
}

    //DELETE
    public void  deleteTransporter(Long id) {
        Transporter transporter = getTransporterById(id);
        transporterRepository.delete(transporter);
    }


}
