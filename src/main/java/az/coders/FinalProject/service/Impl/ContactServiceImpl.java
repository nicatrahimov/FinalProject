package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.ContactDtoConverter;
import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.exception.BadPeopleGroupName;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.ContactRepository;
import az.coders.FinalProject.service.CompanyService;
import az.coders.FinalProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactDtoConverter contactDtoConverter;
    private final CompanyService companyService;

    @Override
    public List<ContactResponseDto> getAllContact() {

        List<Contact> all = contactRepository.findAll();
        List<ContactResponseDto>allDto = new ArrayList<>();

        for(Contact contact:all){
            ContactResponseDto contactDto = contactDtoConverter.toContactRespDto(contact);
            allDto.add(contactDto);
        }
        return allDto;
    }

    @Override
    public ContactResponseDto getContactById(String id) {
        Contact contact = contactRepository.findById(id).orElseThrow(()->new ContactNotFound("Contact not found with id: "+id));
        return contactDtoConverter.toContactRespDto(contact);
    }

    @Override
    public String editContact(ContactRequestDto contactDto) {
        if (contactDto != null && contactDto.getId()!=null) {
            Contact contact = contactRepository.findById(contactDto.getId()).orElseThrow(()->new ContactNotFound("Contact not found with id: "+contactDto.getId()));
            if (contactDto.getFirstName()!=null) {
                contact.setFirstName(contactDto.getFirstName());
            }
            if (contactDto.getLastName()!=null){
                contact.setLastName(contactDto.getLastName());
            }
            if (contactDto.getCity()!=null){
                contact.setCity(contactDto.getCity());
            }
            if (contactDto.getCountry()!=null){
                contact.setCountry(contactDto.getCountry());
            }
            if (contactDto.getAddress()!=null){
                contact.setAddress(contactDto.getAddress());
            }
            if (contactDto.getEmail()!=null){
                contact.setEmail(contactDto.getEmail());
            }
            if (contactDto.getPeopleGroup()!=null){
                contact.setPeopleGroup(PeopleGroup.valueOf(contactDto.getPeopleGroup().toUpperCase()));
            }else throw new  BadPeopleGroupName("Choose any People group please! People Group field is null!");
            contact.setImage(
                    Image.builder()
                    .base64(contactDto.getImage().getBase64())
                    .build());
            if (contactDto.getCompanyId()!=null && contact.getPeopleGroup()==PeopleGroup.EMPLOYER){
                contact.setCompany(companyService.getCompanyEntityById(contactDto.getCompanyId()));
            }
            contactRepository.save(contact);
            return "Successfully edited";
        }else throw new NullPointerException("Object or Id is cannot be null");
    }



    @Override
    public String addContact(ContactRequestDto from) {
        if (from.getPeopleGroup().equalsIgnoreCase("CLIENT") ||
                from.getPeopleGroup().equalsIgnoreCase("EMPLOYER")){
            Contact contact = contactDtoConverter.contactReqToEntity(from);
            contactRepository.save(contact);
            return "Successfully added, id: " + contact.getId();
        }else throw new BadPeopleGroupName("Bad people group name");
    }

    @Override
    public String deleteContactById(String id) {
        if (id!=null){
            Contact contact = contactRepository.findById(id).orElseThrow(()->new ContactNotFound("Contact not found with id: "+id));
            contactRepository.delete(contact);
            return "Deleted successfully";
        }else throw new  NullPointerException("Insert id please!");
    }
}
