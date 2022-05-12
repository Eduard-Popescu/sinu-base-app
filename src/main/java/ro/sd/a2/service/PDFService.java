package ro.sd.a2.service;

import com.lowagie.text.DocumentException;
import ro.sd.a2.domain.entity.dto.PDFInformationDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface PDFService {

  List<PDFInformationDTO> listAllInformationForPDF();
  void export(HttpServletResponse response) throws DocumentException, IOException;

}
