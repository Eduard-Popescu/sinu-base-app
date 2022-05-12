package ro.sd.a2.service.serviceImp;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.dto.PDFInformationDTO;
import ro.sd.a2.mapper.PDFMapper;
import ro.sd.a2.service.PDFService;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PDFServiceImpl implements PDFService {

  private final StudentServiceImpl studentService;

  public PDFServiceImpl(StudentServiceImpl studentService) {
    this.studentService = studentService;
  }

  @Override
  public List<PDFInformationDTO> listAllInformationForPDF() {
     return studentService.getAllStudents().stream().map(PDFMapper::studentToPDFInformationDTO).collect(Collectors.toList());
  }

  @Override
  public void export(HttpServletResponse response) throws DocumentException, IOException {
    List<PDFInformationDTO> pdfInformationDTOS = listAllInformationForPDF();
    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());

    document.open();
    Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    font.setSize(18);
    font.setColor(Color.BLUE);

    Paragraph p = new Paragraph("List of Users", font);
    p.setAlignment(Paragraph.ALIGN_CENTER);

    document.add(p);

    PdfPTable table = new PdfPTable(5);
    table.setWidthPercentage(100f);
    table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
    table.setSpacingBefore(10);

    writeTableHeader(table);
    writeTableData(table,pdfInformationDTOS);

    document.add(table);

    document.close();
  }

  private void writeTableHeader(PdfPTable table) {
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(Color.BLUE);
    cell.setPadding(5);

    Font font = FontFactory.getFont(FontFactory.HELVETICA);
    font.setColor(Color.WHITE);

    cell.setPhrase(new Phrase("Student Name", font));

    table.addCell(cell);

    cell.setPhrase(new Phrase("Student E-mail", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Faculty", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Specialization", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Class Year", font));
    table.addCell(cell);
  }

  private void writeTableData(PdfPTable table,List<PDFInformationDTO> pdfInformationDTOS) {
    for (PDFInformationDTO pdfInformationDTO : pdfInformationDTOS) {
      table.addCell(pdfInformationDTO.getStudentName());
      table.addCell(pdfInformationDTO.getStudentEmail());
      table.addCell(pdfInformationDTO.getFaculty());
      table.addCell(pdfInformationDTO.getSpecializationName());
      table.addCell(pdfInformationDTO.getClassYear());
    }
  }
}
