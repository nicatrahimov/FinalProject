package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.request.EditImageRequest;
import az.coders.FinalProject.exception.Base64FormatIsNotValid;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.CompanyRepository;
import az.coders.FinalProject.repository.ContactRepository;
import az.coders.FinalProject.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private static final String base64Pattern = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$";

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;

    @Override
    public String editContactImage(EditImageRequest request) {
        if (request.getTargetObjectId() != null && Pattern.compile(base64Pattern).matcher(request.getBase64()).matches()){
            Contact contact = contactRepository.findById(request.getTargetObjectId()).orElseThrow(() -> new ContactNotFound("Contact not found with id: " + request.getTargetObjectId()));
            contact.setImage(Image.builder().base64(request.getBase64()).build());
            contactRepository.save(contact);
            return "Successfully added:" + contact.getId();
        }else throw new Base64FormatIsNotValid("Base64 format is not valid or object is null");


    }

    @Override
    public String editCompanyImage(EditImageRequest request) {
        if (request.getTargetObjectId() != null && Pattern.compile(base64Pattern).matcher(request.getBase64()).matches()){
            Company company = companyRepository.findById(request.getTargetObjectId()).orElseThrow(() -> new ContactNotFound("Contact not found with id: " + request.getTargetObjectId()));
            company.setImage(Image.builder().base64(request.getBase64()).build());
            companyRepository.save(company);
            return "Successfully added:" + company.getId();
        }else throw new Base64FormatIsNotValid("Base64 format is not valid or object is null");
    }

    @Override
    public String editCaseImage(EditImageRequest request) {
        return null;
    }
}
