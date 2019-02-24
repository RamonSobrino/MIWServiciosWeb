FROM microsoft/aspnet
WORKDIR /
EXPOSE 80
COPY ./WS.Recomendation.Authentication ./WS.Recomendation.Authentication
SHELL ["powershell", "-command"]
# RUN Get-WebBinding -Port 80 -Name 'Default Web Site' | Remove-WebBinding
# RUN New-WebBinding -Name 'Default Web Site' -Port 9093 -IPAddress *
RUN New-WebApplication -Name WS.Recomendation.Authentication -Site 'Default Web Site' -PhysicalPath C:\WS.Recomendation.Authentication -ApplicationPool DefaultAppPool
