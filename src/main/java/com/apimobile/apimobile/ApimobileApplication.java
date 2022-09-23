package com.apimobile.apimobile;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apimobile.apimobile.entities.Servidor;
import com.apimobile.apimobile.entities.Snapshot;
import com.apimobile.apimobile.entities.VencimentoDesconto;
import com.apimobile.apimobile.entities.Vinculo;
import com.apimobile.apimobile.repositories.ServidorRepository;
import com.apimobile.apimobile.repositories.SnapshotRepository;
import com.apimobile.apimobile.repositories.VinculoRepository;

@SpringBootApplication
public class ApimobileApplication {

	@Autowired
	ServidorRepository servidorRepository;

	@Autowired
	VinculoRepository vinculoRepository;

	@Autowired
	SnapshotRepository snapshotRepository;

	@PostConstruct
    public void initBanco() {
		System.out.println("Iniciando povoamento do banco...");

        LocalDateTime inicio = LocalDateTime.now();

		servidorRepository.save(new Servidor("Ronaldo Dantas","385.893.490-98","1234678-9"));

		List<Servidor> servidoresNoRepositorio = servidorRepository.findAll();

		vinculoRepository.save(new Vinculo("Departamento Estadual de Transito", "Coordenadoria de Informática","567422","Assistente administrativo","DETRAN", servidoresNoRepositorio.get(0)));

		List<Snapshot> snapshots = snapshotRepository.buscarComData("01-01-2022");

		Snapshot snapshot = snapshots.get(0);

		snapshot.addVencimentoDesconto(new VencimentoDesconto("001","Vencimento", new BigDecimal("4000.00"),"Vantagem","01-01-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("343","Auxílio alimentação", new BigDecimal("800.00"),"Vantagem","01-01-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("502","Imposto de Renda", new BigDecimal("450.00"),"Desconto","01-01-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("543","IPE", new BigDecimal("600.00"),"Desconto","01-01-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("001","Vencimento", new BigDecimal("4000.00"),"Vantagem","01-02-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("343","Auxílio alimentação", new BigDecimal("800.00"),"Vantagem","01-02-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("502","Imposto de Renda", new BigDecimal("450.00"),"Desconto","01-02-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("543","IPE", new BigDecimal("600.00"),"Desconto","01-02-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("001","Vencimento", new BigDecimal("4000.00"),"Vantagem","01-03-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("343","Auxílio alimentação", new BigDecimal("800.00"),"Vantagem","01-03-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("502","Imposto de Renda", new BigDecimal("450.00"),"Desconto","01-03-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("543","IPE", new BigDecimal("600.00"),"Desconto","01-03-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("001","Vencimento", new BigDecimal("4000.00"),"Vantagem","01-04-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("343","Auxílio alimentação", new BigDecimal("800.00"),"Vantagem","01-04-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("502","Imposto de Renda", new BigDecimal("450.00"),"Desconto","01-04-2022"));
		snapshot.addVencimentoDesconto(new VencimentoDesconto("543","IPE", new BigDecimal("600.00"),"Desconto","01-04-2022"));

		snapshotRepository.saveAll(snapshots);
		
		LocalDateTime fim = LocalDateTime.now();

        System.out.println("Povoamento do banco concluído em: " + Duration.between(inicio, fim));
	}
	public static void main(String[] args) {
		SpringApplication.run(ApimobileApplication.class, args);
	}

}
